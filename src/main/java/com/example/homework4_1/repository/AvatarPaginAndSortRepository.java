package com.example.homework4_1.repository;

import com.example.homework4_1.model.Avatar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarPaginAndSortRepository extends PagingAndSortingRepository<Avatar, Long> {


}
