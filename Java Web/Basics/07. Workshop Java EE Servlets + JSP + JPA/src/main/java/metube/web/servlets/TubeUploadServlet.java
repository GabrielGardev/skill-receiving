package metube.web.servlets;

import metube.domain.models.binding.TubeUploadBindingModel;
import metube.domain.models.service.TubeServiceModel;
import metube.service.TubeService;
import metube.service.UserService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tube/upload")
public class TubeUploadServlet extends HttpServlet {

    private final TubeService tubeService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Inject
    public TubeUploadServlet(TubeService tubeService, UserService userService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/upload.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TubeUploadBindingModel tubeUploadBindingModel
                = (TubeUploadBindingModel) req.getAttribute("tubeModel");

        String youtubeId = tubeUploadBindingModel.getYoutubeLink().split("=")[1];

        TubeServiceModel tubeServiceModel = modelMapper.map(tubeUploadBindingModel, TubeServiceModel.class);
        tubeServiceModel.setYoutubeId(youtubeId);
        tubeServiceModel.setUploader(userService.findUserByUsername(tubeUploadBindingModel.getUploader()));

        tubeService.uploadTube(tubeServiceModel);

        resp.sendRedirect("/home");
    }
}
