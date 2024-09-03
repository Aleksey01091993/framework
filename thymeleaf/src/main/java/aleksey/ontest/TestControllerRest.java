package aleksey.ontest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestControllerRest {

    private final TestRepository testRepository;

    @PostMapping("/create")
    public void create() {
        testRepository.save(TestEntity.builder().name("name").description("description").build());
    }

    @GetMapping("/get")
    public List<TestEntity> getTestEntity() {
        List<TestEntity> list = testRepository.findAll();
        return list;
    }

}
