package softuni.exam.service;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.json.PlayerDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Player;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.PlayerRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final static String PLAYERS_FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\json\\players.json";

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, PictureRepository pictureRepository, FileUtil fileUtil, Gson gson, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public String importPlayers() throws IOException {
        StringBuilder sb = new StringBuilder();

        PlayerDto[] playerDtos = gson.fromJson(readPlayersJsonFile(), PlayerDto[].class);
        for (PlayerDto dto : playerDtos) {
            Player player = mapper.map(dto, Player.class);
            Picture picture = pictureRepository.findByUrl(dto.getPicture().getUrl());
            Team team = teamRepository.findByName(dto.getTeam().getName());
            if (!validatorUtil.isValid(player) || picture == null || team == null){
                sb.append("Invalid player").append(System.lineSeparator());
                continue;
            }

            player.setPicture(picture);
            player.setTeam(team);
            playerRepository.saveAndFlush(player);
            sb.append("Successfully imported player - ")
                    .append(player.getFirstName())
                    .append(" ")
                    .append(player.getLastName())
                    .append(System.lineSeparator());
        }


        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {
        return fileUtil.readFile(PLAYERS_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
        StringBuilder sb = new StringBuilder();
        BigDecimal salary = new BigDecimal("100000");
        String separator = System.lineSeparator();

        List<Player> allBySalaryGreaterThan = playerRepository.findAllBySalaryGreaterThanOrderBySalaryDesc(salary);

        for (Player player : allBySalaryGreaterThan) {
            sb.append("Player name: ")
                    .append(player.getFirstName())
                    .append(" ")
                    .append(player.getLastName())
                    .append(separator)
                    .append("   Number: ")
                    .append(player.getNumber())
                    .append(separator)
                    .append("   Salary: ")
                    .append(player.getSalary())
                    .append(separator)
                    .append("   Team: ")
                    .append(player.getTeam().getName())
                    .append(separator);
        }

        return sb.toString().trim();
    }

    @Override
    public String exportPlayersInATeam() {
        StringBuilder sb = new StringBuilder();
        String teamName = "North Hub";
        String separator = System.lineSeparator();

        List<Player> playersInATeam = playerRepository.findPlayersInATeam(teamName);

        sb.append("Team: ").append(teamName).append(separator);
        for (Player player : playersInATeam) {
            sb.append("    Player name: ")
                    .append(player.getFirstName())
                    .append(" ")
                    .append(player.getLastName())
                    .append(" - ")
                    .append(player.getPosition())
                    .append(separator)
                    .append("    Number: ")
                    .append(player.getNumber())
            .append(separator);
        }
        return sb.toString().trim();
    }
}
