package com.epam.eugene.entity;

import com.epam.eugene.exception.BasicArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class BasicArray {

    private static final Logger logger = LogManager.getLogger();
    private static final String MESSAGE_ERROR = "getElement() Index is illegal";
    private int[] array;

    public BasicArray() {
        array = new int[0];
    }

    public BasicArray(int[] array) throws BasicArrayException {
        if (array == null) {
            throw new BasicArrayException("Array init is NULL.");
        }
        this.array  = array;
    }

    public BasicArray(int sizeArray) throws BasicArrayException {
        if (sizeArray < 1) {
            logger.error("constructore BasicArray sizeArray less than 1");
            throw new BasicArrayException("size array: " + sizeArray + " less than zero");
        }
        this.array = new int[sizeArray];
        logger.error("Array created with size " + sizeArray);
    }

    public int getSize() throws BasicArrayException {
        if (this == null) {
            throw new BasicArrayException("Array is null");
        }
        return array.length;
    }

    public int getElement(int index) throws BasicArrayException {
        if (index >= array.length || index < 0) {
            logger.error(MESSAGE_ERROR);
           throw new BasicArrayException(MESSAGE_ERROR);
        }
        return this.array[index];
    }

    public void setElement(int index, int element) throws BasicArrayException {
        if (index >= array.length || index < 0) {
            logger.error(MESSAGE_ERROR);
            throw new BasicArrayException(MESSAGE_ERROR);
        }
        this.array[index] = element;
    }

    public boolean isEmpty() throws BasicArrayException {
        if (this == null) {
            throw new BasicArrayException("Array is null");
        }
        return array.length == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\nArray: " + array.length + " elements\n");
        for (int value : this.array) {
            stringBuilder.append(value).append(" ");
        }
        return stringBuilder.toString();
    }

    public int[] getArray() throws BasicArrayException {
        if (array.length < 1) {
            logger.error("getArray() Array is empty");
            throw new BasicArrayException("array is empty");
        }
        return this.array.clone();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        BasicArray basicArray = (BasicArray) object;
        return Arrays.equals(this.array, basicArray.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

}