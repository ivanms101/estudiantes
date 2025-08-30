package co.edu.uniremington.ivansanchez.estudiantes.Controllers;

import co.edu.uniremington.ivansanchez.estudiantes.Models.Estudiantes;
import co.edu.uniremington.ivansanchez.estudiantes.Services.IAdministradorArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EstudianteController {
    @Autowired
    IAdministradorArray administradorArray;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/registro")
    public String registro(Model model){
        model.addAttribute("estudiante", new  Estudiantes());
        return "registro";
    }

    @PostMapping("/registro")
    public String crear(@ModelAttribute Estudiantes estudiante, RedirectAttributes redirectAttributes){
        administradorArray.crear(estudiante);
        redirectAttributes.addFlashAttribute("mensaje","Registro creado exitosamente");
        return "redirect:/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model){
        model.addAttribute("estudiantes", administradorArray.listar());
        return "lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id, RedirectAttributes redirectAttributes) {
        administradorArray.eliminar(id);
        redirectAttributes.addFlashAttribute("mensaje", "Registro eliminado correctamente");
        return "redirect:/lista";
    }

    @GetMapping("/formulario/{id}")
    public String editar(@PathVariable int id, Model model){
        Estudiantes estudiante = administradorArray.buscar(id);
        model.addAttribute("estudiante", estudiante);
        return "registro";
    }

    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Estudiantes estudiante, RedirectAttributes redirectAttributes){
        administradorArray.actualizar(estudiante, estudiante.getId());
        redirectAttributes.addFlashAttribute("mensaje", "Registro actualizado correctamente");
        return "redirect:/lista";
    }
}
