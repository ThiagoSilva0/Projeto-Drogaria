/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.util;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Thiago Silva
 */
public class FacesUtil {

    public static void adicionarMsgInfo(String mensagem) {
        
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage(mensagem) );
        

    }

    public static void adicionarMsgError(String mensagem) {

        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext context =  FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(facesMessage.toString()));
    }
    public static String getParam(String nome){
    
            FacesContext context =  FacesContext.getCurrentInstance();
            ExternalContext externalContext = context.getExternalContext();
            Map<String,String> parametros = externalContext.getRequestParameterMap();
            String valor = parametros.get(nome);
            
            return valor;
    }
}
