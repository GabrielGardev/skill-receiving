package metube.web.servlets;

import metube.domain.models.service.TubeServiceModel;
import metube.domain.models.view.AllTubesViewModel;
import metube.service.TubeService;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private final TubeService tubeService;
    private final ModelMapper modelMapper;

    @Inject
    public HomeServlet(TubeService tubeService, ModelMapper modelMapper) {
        this.tubeService = tubeService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TubeServiceModel> allTubes = tubeService.findAllTubes();
        List<AllTubesViewModel> tubes = new ArrayList<>();
        for (TubeServiceModel tube : allTubes) {
            tubes.add(modelMapper.map(tube, AllTubesViewModel.class));
        }
        req.getSession().setAttribute("tubes", tubes);
        req.getRequestDispatcher("/jsp/home.jsp").forward(req, resp);
    }
}
