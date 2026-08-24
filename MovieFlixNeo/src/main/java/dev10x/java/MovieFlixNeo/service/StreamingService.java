package dev10x.java.MovieFlixNeo.service;

import dev10x.java.MovieFlixNeo.entity.Category;
import dev10x.java.MovieFlixNeo.entity.Streaming;
import dev10x.java.MovieFlixNeo.repository.CategoryRepository;
import dev10x.java.MovieFlixNeo.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository streamingRepository;


    public List<Streaming> findAll() {
        return streamingRepository.findAll();
    }

    public Streaming salvar(Streaming streaming){
        return streamingRepository.save(streaming);
    }

    public Optional< Streaming > buscarPorId(Long id){
        return streamingRepository.findById(id);
    }

    public void deletar(Long id){
        streamingRepository.deleteById(id);
    }

}
