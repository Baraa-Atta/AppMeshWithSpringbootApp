package com.example.aerospikespringboot.repositories;


import com.example.aerospikespringboot.objects.User;
import org.springframework.data.aerospike.repository.AerospikeRepository;


public interface AerospikeUserRepository extends AerospikeRepository<User, Integer> {

}
