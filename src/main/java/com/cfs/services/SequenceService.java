package com.cfs.services;

import com.cfs.exception.SequenceException;

public interface SequenceService {

	long getNextSequenceId(String key)throws SequenceException;
}
