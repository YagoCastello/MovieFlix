package dev10x.java.MovieFlixNeo.controller;

import dev10x.java.MovieFlixNeo.entity.Streaming;
import dev10x.java.MovieFlixNeo.mapper.StreamingMapper;
import dev10x.java.MovieFlixNeo.request.StreamingRequest;
import dev10x.java.MovieFlixNeo.response.StreamingResponse;
import dev10x.java.MovieFlixNeo.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("movieflix/streaming")
public class StreamingController {

    private final StreamingService streamingService;



    @GetMapping("/listar")
    public ResponseEntity<List<StreamingResponse>> getAllStreamings() {
        List<Streaming> streamings = streamingService.findAll();
        List<StreamingResponse> list = streamings
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/criar")
    public ResponseEntity< StreamingResponse> saveStreaming(@RequestBody StreamingRequest request) {
        Streaming newStreaming = StreamingMapper.toStreaming(request);
        Streaming saveStreaming = streamingService.salvar(newStreaming);
        return ResponseEntity.status(HttpStatus.CREATED).body(StreamingMapper.toStreamingResponse(saveStreaming));

    }
    @GetMapping("encontre/{id}")
    public ResponseEntity< StreamingResponse>  getStreamingById(@PathVariable Long id){
        return streamingService.buscarPorId(id)
                .map(streaming -> ResponseEntity.ok(StreamingMapper.toStreamingResponse(streaming)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteStreaming(@PathVariable Long id){
        streamingService.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
