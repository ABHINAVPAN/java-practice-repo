package com.example.crud.controller;

import com.example.crud.dto.ProductRequest;
import com.example.crud.model.Product;
import com.example.crud.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductPageController {
    private final ProductService productService;

    public ProductPageController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", productService.findAll());
        return "products/list";
    }

    @GetMapping("/new")
    public String newForm(Model model) {
        model.addAttribute("product", new ProductRequest("", "", null));
        return renderForm(model, "Add product", "/products");
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("product") ProductRequest request,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return renderForm(model, "Add product", "/products");
        }
        productService.create(request);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", new ProductRequest(
                product.getName(), product.getDescription(), product.getPrice()));
        return renderForm(model, "Edit product", "/products/" + id);
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute("product") ProductRequest request,
                         BindingResult bindingResult,
                         Model model) {
        productService.findById(id);
        if (bindingResult.hasErrors()) {
            return renderForm(model, "Edit product", "/products/" + id);
        }
        productService.update(id, request);
        return "redirect:/products";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/products";
    }

    private String renderForm(Model model, String title, String action) {
        model.addAttribute("pageTitle", title);
        model.addAttribute("formAction", action);
        return "products/form";
    }
}