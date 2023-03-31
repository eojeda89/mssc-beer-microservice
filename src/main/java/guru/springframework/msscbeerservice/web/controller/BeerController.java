package guru.springframework.msscbeerservice.web.controller;

import guru.springframework.msscbeerservice.services.BeerService;
import guru.springframework.msscbeerservice.web.model.BeerDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBerById(@NotNull @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getByID(beerId), OK);
    }

    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@NotNull @PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        return new ResponseEntity<>(beerService.updateBeer(beerId, beerDto), NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@NotNull @PathVariable("beerId") UUID beerId) {
        return new ResponseEntity(beerService.deleteById(beerId), OK);
    }
}
