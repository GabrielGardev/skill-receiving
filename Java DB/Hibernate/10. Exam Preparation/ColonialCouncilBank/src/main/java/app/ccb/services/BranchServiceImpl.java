package app.ccb.services;

import app.ccb.domain.dtos.BranchImportDto;
import app.ccb.domain.entities.Branch;
import app.ccb.repositories.BranchRepository;
import app.ccb.util.FileUtil;
import app.ccb.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BranchServiceImpl implements BranchService {

    private final static String BRANCHES_JSON_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\ColonialCouncilBank\\src\\main\\resources\\files\\json\\branches.json";

    private final BranchRepository branchRepository;

    private final FileUtil fileUtil;

    private final Gson gson;

    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.branchRepository = branchRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() != 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {

        return this.fileUtil.readFile(BRANCHES_JSON_FILE_PATH);
    }

    @Override
    public String importBranches(String branchesJson) {
        StringBuilder importResult = new StringBuilder();

        BranchImportDto[] branchImportDtos = this.gson.fromJson(branchesJson, BranchImportDto[].class);

        for (BranchImportDto branchImportDto : branchImportDtos) {

            if (!this.validationUtil.isValid(branchImportDto)) {

                importResult.append("Error: Incorrect Data!").append(System.lineSeparator());
                continue;
            }

            Branch branch = this.modelMapper.map(branchImportDto, Branch.class);
            this.branchRepository.saveAndFlush(branch);

            importResult.append(String.format("Successfully imported Branch - %s", branchImportDto.getName()))
                    .append(System.lineSeparator());

        }
        return importResult.toString().trim();
    }
}
