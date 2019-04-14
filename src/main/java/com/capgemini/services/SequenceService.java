package com.capgemini.services;

import com.capgemini.exception.SequenceException;

public interface SequenceService {

	long getNextSequenceId(String key)throws SequenceException;
}
