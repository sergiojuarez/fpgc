/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.mx.salud.api.util;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * Clase generica para envolver las respuestas de acuerdo al estandar HTTP
 * @author ETI2CAOL
 * @since 01/03/2015
 * @version 1.0.0
 */
/**
 * @author ETI2CAOL
 *
 * @param <T>
 */
@SuppressWarnings("serial")
public class ResponseWrapper<T> implements Serializable {



    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    public static final String ERROR = "error";

    private String status;
    private Integer code;
    private String message;
    private T data;
    private String titulo;

    /**
     * Constructor vacio
     */
    public ResponseWrapper() {
        super();
    }


    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }


    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }


    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * @param code the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }


    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }


    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * @return the data
     */
    public T getData() {
        return data;
    }


    /**
     * @param data the data to set
     */
    public void setData(T data) {
        this.data = data;
    }


    public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	/**
     * Genera una respuesta genérica exitosa.
     * @param status
     * @param code
     * @param data
     */
    private void success(String status, Integer code, T data) {
        this.status = status;
        this.code = code;
        this.data = data;

    }

    /**
     * Genera una respuesta erronea del tipo <b>ERROR</b>.
     * @param status
     * @param code
     * @param message
     * @param data
     */
    public void error(String status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Genera una respuesta erronea del tipo <b>FAIL</b>.
     * @param status
     * @param code
     * @param message
     * @param data
     */
    public void fail(String status, Integer code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Genera una respuesta erronea del tipo <b>FAIL</b>.
     * @param status
     * @param code
     * @param message
     * @param data
     */
    public void exception(String titulo, String status, Integer code, String message, T data) {
    	this.titulo = titulo;
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Genera una respuesta exitosa para peticiones <b>GET</b>.
     * @param data {@code T}
     * @return {@code ResponseWrapper<T>}
     */
//    public ResponseWrapper<T> successGET(T data) {
//        success(ResponseWrapper.SUCCESS, HttpStatus.OK.value(), data);
//        return this;
//    }

    /**
     * Genera una respuesta exitosa para peticiones <b>POST</b>.
     * @param data {@code T}
     * @return {@code ResponseWrapper<T>}
     */
    public ResponseWrapper<T> successPOST(T data) {
        success(ResponseWrapper.SUCCESS, HttpStatus.CREATED.value(), data);
        return this;
    }

    /**
     * Genera una respuesta exitosa para peticiones <b>PUT</b>.
     * @param data {@code T}
     * @return {@code ResponseWrapper<T>}
     */
    public ResponseWrapper<T> successPUT(T data) {
        success(ResponseWrapper.SUCCESS, HttpStatus.OK.value(), data);
        return this;
    }

    /**
     * Genera una respuesta exitosa para peticiones <b>DELETE</b>.
     * @param data {@code T}
     * @return {@code ResponseWrapper<T>}
     */
    public ResponseWrapper<T> successDELETE(T data) {
        success(ResponseWrapper.SUCCESS, HttpStatus.OK.value(), data);
        return this;
    }

    /**
     * Genera una respuesta fallida del tipo <b>400-BAD_REQUEST</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> errorBadRequest(String message, List<ErrorDetail> data) {
        error(ResponseWrapper.ERROR, HttpStatus.BAD_REQUEST.value(), message, (T) data);
        return this;
    }
    /**
     * Genera una respuesta fallida del tipo <b>401-UNAUTHORIZED</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> errorUnauthorized(String message, List<ErrorDetail> data) {
        error(ResponseWrapper.ERROR, HttpStatus.UNAUTHORIZED.value(), message, (T) data);
        return this;
    }
    /**
     * Genera una respuesta fallida del tipo <b>404-NOT_FOUND</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    public ResponseWrapper<T> errorNotFound(String message) {
        error(ResponseWrapper.SUCCESS, HttpStatus.NOT_FOUND.value(), message, null);
        return this;
    }

    /**
     * Genera una respuesta fallida del tipo <b>409-CONFLICT</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> errorConflict(String message, List<ErrorDetail> data) {
        error(ResponseWrapper.ERROR, HttpStatus.CONFLICT.value(), message, (T) data);
        return this;
    }
    /**
     * Genera una respuesta fallida del tipo <b>501-NOT_IMPLEMENTED</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> failNotImplemented(String message, List<ErrorDetail> data) {
        fail(ResponseWrapper.FAIL, HttpStatus.NOT_IMPLEMENTED.value(), message, (T) data);
        return this;
    }

    /**
     * Genera una respuesta exitosa del tipo <b>201-NOT_AUTHORIZATION</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> created(String message, List<ErrorDetail> data) {
        fail(ResponseWrapper.FAIL, HttpStatus.CREATED.value(), message, (T) data);
        return this;
    }

    /**
     * Genera una respuesta fallida del tipo <b>500-INTERNAL_SERVER_ERROR</b>
     * @param message
     * @param data
     * @return {@code ResponseWrapper<T>}
     */
    @SuppressWarnings("unchecked")
    public ResponseWrapper<T> failServerError(String message, String data) {
        fail(ResponseWrapper.FAIL, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, (T) data);
        return this;
    }
}
