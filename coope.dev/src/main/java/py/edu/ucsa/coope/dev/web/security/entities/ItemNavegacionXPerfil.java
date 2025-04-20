package py.edu.ucsa.coope.dev.web.security.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import py.edu.ucsa.coope.dev.core.entities.Opcion; // o la entidad real

@Entity
@Table(name = "usu_items_nav_x_perfil", schema = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemNavegacionXPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_item_navegacion")
    private ItemNavegacion itemNavegacion;

    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Opcion estado; // <-- asegurate de que Opcion también sea entidad
}
