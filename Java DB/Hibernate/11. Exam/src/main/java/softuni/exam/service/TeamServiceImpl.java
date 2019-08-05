package softuni.exam.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.domain.dtos.xml.TeamDto;
import softuni.exam.domain.dtos.xml.TeamRootDto;
import softuni.exam.domain.entities.Picture;
import softuni.exam.domain.entities.Team;
import softuni.exam.repository.PictureRepository;
import softuni.exam.repository.TeamRepository;
import softuni.exam.util.FileUtil;
import softuni.exam.util.ValidatorUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class TeamServiceImpl implements TeamService {

    private final static String TEAMS_FILE_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\files\\xml\\teams.xml";

    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final FileUtil fileUtil;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper mapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, PictureRepository pictureRepository, FileUtil fileUtil, XmlParser xmlParser, ValidatorUtil validatorUtil, ModelMapper mapper) {
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.fileUtil = fileUtil;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.mapper = mapper;
    }

    @Override
    public String importTeams() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        TeamRootDto teamRootDto = xmlParser.parseXml(TeamRootDto.class, TEAMS_FILE_PATH);
        for (TeamDto dto : teamRootDto.getTeams()) {
            Team team = mapper.map(dto, Team.class);
            Picture picture = pictureRepository.findByUrl(dto.getPicture().getUrl());
            if (!validatorUtil.isValid(team) || picture == null){
                sb.append("Invalid team").append(System.lineSeparator());
                continue;
            }

            team.setPicture(picture);
            teamRepository.saveAndFlush(team);
            sb.append("Successfully imported team - ").append(team.getName()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws IOException {
        return fileUtil.readFile(TEAMS_FILE_PATH);
    }
}
