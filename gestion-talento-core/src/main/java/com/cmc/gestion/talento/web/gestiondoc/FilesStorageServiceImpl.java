package com.cmc.gestion.talento.web.gestiondoc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

	@Autowired
	private Environment env;

	@Override
	public void init() {
		try {
			Path root =getPathRoot();
			if (!Files.exists(root)) {
				Files.createDirectory(root);
			}
		} catch (IOException e) {
			throw new RuntimeException("No se puede crear directorio para gestion doc");
		}
	}

	@Override
	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), getPathRoot().resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}

	}

	@Override
	public Resource load(String filename) {
		try {
			Path file = getPathRoot().resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(getPathRoot().toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			Path root =getPathRoot();
			return Files.walk(root, 1).filter(path -> !path.equals(root)).map(root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}

	@Override
	public void createSerie(String patch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createSubserie(String patch) {
		// TODO Auto-generated method stub

	}
	
	private Path getPathRoot() {
		String patchRoot = env.getProperty("com.cmc.gestiondoc.root");
		Path root = Paths.get(patchRoot);
		return root;
	}

	@Override
	public void save(MultipartFile file, String newName) {
		try {
			Files.copy(file.getInputStream(), getPathRoot().resolve(newName));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		
	}

	@Override
	public Resource createSimpleFile(String name) {
		  try {
			 Path pathFile= getPathRoot().resolve(name);
			if(Files.exists(pathFile)) {
				Files.delete(pathFile);
			}
			Files.createFile(pathFile);
			return load(name);
		} catch (IOException e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

}
