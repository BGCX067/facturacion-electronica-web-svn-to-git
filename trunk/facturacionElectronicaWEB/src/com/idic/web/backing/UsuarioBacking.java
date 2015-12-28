package com.idic.web.backing;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.idic.ejb.entities.Usuario;
import com.idic.ejb.services.UsuarioServiceLocal;
import com.idic.web.bean.UsuarioBean;

@ManagedBean
@RequestScoped
public class UsuarioBacking {

	@EJB
	private UsuarioServiceLocal usuarioServiceLocal;

	@ManagedProperty(value = "#{usuarioBean}")
	private UsuarioBean usuarioBean;

	public void cargarDatos() throws Exception {

		usuarioBean.setListaUsuario(usuarioServiceLocal.findAll());

		for (Usuario item : usuarioBean.getListaUsuario()) {
			System.out.println(item.getNombre()	);
		}

	}

	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}

	public void setUsuarioBean(UsuarioBean usuarioBean) {
		this.usuarioBean = usuarioBean;
	}

}
