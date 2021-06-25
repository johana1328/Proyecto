package com.cmc.gestion.talento.web.gestiondoc;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
	  public void init();
	  public void createSerie(String patch);
	  public void createSubserie(String patch);
	  public void save(MultipartFile file);
	  public void save(MultipartFile file, String newName);
	  public Resource load(String filename);
	  public void deleteAll();
	  public Stream<Path> loadAll();
	  public Resource createSimpleFile(String name);
}
