package ru.gb.springdemo.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.springdemo.model.Book;
import ru.gb.springdemo.model.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ReaderRepository {

  private final List<Reader> readers;

  public ReaderRepository() {
    this.readers = new ArrayList<>();
  }

  @PostConstruct
  public void generateData() {
    readers.addAll(List.of(
      new ru.gb.springdemo.model.Reader("Игорь")
    ));
  }

  public Reader getReaderById(long id) {
    return readers.stream().filter(it -> Objects.equals(it.getId(), id))
      .findFirst()
      .orElse(null);
  }
  public Reader delreaderById(long id){
    Reader reader = getReaderById(id);
    if (reader != null){
      readers.remove(reader);
    }
    return reader;
  }
  public Reader createReader(String name){
    Reader reader = new Reader(name);
    readers.add(reader);
    return reader;
  }
  public List<Reader> getAllReader(){
    List<Reader>copyReader = new ArrayList<>(readers);
    return copyReader;
  }

}
