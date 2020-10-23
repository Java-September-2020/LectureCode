package com.matthew.fakeinsta.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.matthew.fakeinsta.models.Picture;
import com.matthew.fakeinsta.models.User;

public interface PictureRepository extends CrudRepository<Picture, Long>{
	List<Picture> findAllByUser(User user);
}
