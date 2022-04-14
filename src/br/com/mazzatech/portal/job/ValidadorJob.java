package br.com.mazzatech.portal.job;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mazzatech.portal.model.Produto;
import br.com.mazzatech.portal.service.ProdutoService;
import br.com.mazzatech.portal.util.FacesUtils;

@Component
public class ValidadorJob implements Job {

	private final ProdutoService produtoService;

	@Autowired
	public ValidadorJob(ProdutoService produtoService, FacesUtils facesUtils) {
		this.produtoService = produtoService;
	}

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		List<Produto> produtos = produtoService.listaTudo();

		for (Produto produto : produtos) {

			System.out.println("Verifica todos produtos. At " + new Date());
			System.out.println("Código " + produto.getCodigo());
			System.out.println("Nome " + produto.getNome());
			System.out.println("Descrição " + produto.getDescricao());
			System.out.println("Preço " + produto.getPreco());
		}
	}

}
