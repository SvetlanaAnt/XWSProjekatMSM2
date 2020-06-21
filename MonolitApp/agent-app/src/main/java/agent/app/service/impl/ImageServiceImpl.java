package agent.app.service.impl;

import agent.app.dto.image.ImageDTO;
import agent.app.exception.ExistsException;
import agent.app.exception.NotFoundException;
import agent.app.model.Image;
import agent.app.repository.CarRepository;
import agent.app.repository.ImageRepository;
import agent.app.service.intf.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${directory.prop}")
    private String photoDir;

    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).orElseThrow(()-> new NotFoundException("Slika ne postoji"));
    }

    @Override
    public Image findByName(String name) {
        return imageRepository.findByName(name);
    }

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image save(Image image) {
        if(image.getId() != null){
            if(imageRepository.existsById(image.getId())){
                throw new ExistsException(String.format("Slika vec postoji."));
            }
        }
        return imageRepository.save(image);
    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public Image createImage(String imageName) {
        Image img = new Image();
        img.setName(imageName);
        img = this.save(img);
        return img;
    }

    @Override
    public Image editImage(Image image) {
        this.findById(image.getId());
        return imageRepository.save(image);
    }

    @Override
    public Integer deleteById(Long id) {
        Image image = this.findById(id);
        this.delete(image);
        return 1;
    }

    @Override
    public Integer getImageSize() {
        if(this.findAll() == null){
            return 0;
        }
        Integer i = this.findAll().size();
        return i;
    }


    @Override
    public ImageDTO findImageLocationByName(String name, Long ad_id)   {
        System.out.println("SERVICE METODA ZA SRC LOAD SLIKE");
        Image image = imageRepository.findByName(name);

        File folder = new File("images");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            String namePhoto = stripExtension(file.getName());
            if(file.isFile() && namePhoto.equals(image.getName())){
                System.out.println(namePhoto);
                ImageDTO.builder()
                        .src(file.getAbsolutePath())
                        .build();
            }
        }

        return null;
    }

    @Override
    public String getImageName() {
        Integer broj = this.getImageSize() + 1;
        String imageName = "slika" + broj;
        return imageName;
    }

    @Override
    public Integer addImage(String imageName) {
        Image img = this.createImage(imageName);
        System.out.println(img.getId() + " " + img.getName());
        return 1;
    }

    @Override
    public String uploadImage(MultipartFile photo) {

        try{
            System.out.println("DIREKTORIJUM: "+ photoDir);
            File file = new File("C:\\XMLPhotos\\agent");
            if(!file.exists()){
                if(!file.mkdirs()){
                    System.out.println("Direktorijum nije kreiran");
                    return null;
                }
            }
            String origName = photo.getOriginalFilename();
            String[] ext = origName.split("\\.");
            System.out.println(ext[0] + "  " + ext[1]);

            String name = this.getImageName();
            System.out.println(file.getAbsolutePath());
            String uploadDirectory = file.getAbsolutePath() + "\\" + name +"." +ext[1];

            File convertFile = new File(uploadDirectory);
            convertFile.createNewFile();
            FileOutputStream fout = new FileOutputStream(convertFile);
            fout.write(photo.getBytes());
            fout.close();

            Integer rez = this.addImage(name);
            if(rez != 1){
                System.out.println("desila se greska prilikom dodavanja slike");
                return null;
            }
            System.out.println("dodata slika");
            return name;
        }catch(Exception e){
            return null;
        }
    }


    static String stripExtension (String str) {

        if (str == null) return null;
        int pos = str.lastIndexOf(".");
        if (pos == -1) return str;
        return str.substring(0, pos);
    }


}
