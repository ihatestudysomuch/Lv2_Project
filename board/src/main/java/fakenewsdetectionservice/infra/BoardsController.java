package fakenewsdetectionservice.infra;

import fakenewsdetectionservice.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/boards")
@Transactional
public class BoardsController {

    @Autowired
    BoardsRepository boardsRepository;

//    @RequestMapping(
//            value = "/boards/{id}/reject",
//            method = RequestMethod.DELETE,
//            produces = "application/json;charset=UTF-8"
//    )
//    public Boards reject(
//            @PathVariable(value = "id") Long id,
//            HttpServletRequest request,
//            HttpServletResponse response
//    ) throws Exception {
//        System.out.println("##### /boards/reject  called #####");
//        Optional<Boards> optionalBoards = boardsRepository.findById(id);
//
//        optionalBoards.orElseThrow(() -> new Exception("No Entity Found"));
//        Boards boards = optionalBoards.get();
//        boards.reject();
//
//        boardsRepository.delete(boards);
//        return boards;
//    }

    @RequestMapping(
            value = "/boards/{id}/like",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8"
    )
    public Boards like(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /boards/like  called #####");
        Optional<Boards> optionalBoards = boardsRepository.findById(id);

        optionalBoards.orElseThrow(() -> new Exception("No Entity Found"));
        Boards boards = optionalBoards.get();
        boards.like();

        boardsRepository.save(boards);
        return boards;
    }

    @RequestMapping(
            value = "/boards/{id}/bad",
            method = RequestMethod.PUT,
            produces = "application/json;charset=UTF-8"
    )
    public Boards bad(
            @PathVariable(value = "id") Long id,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /boards/bad  called #####");
        Optional<Boards> optionalBoards = boardsRepository.findById(id);

        optionalBoards.orElseThrow(() -> new Exception("No Entity Found"));
        Boards boards = optionalBoards.get();
        boards.bad();

        boardsRepository.save(boards);
        return boards;
    }
}
//>>> Clean Arch / Inbound Adaptor
