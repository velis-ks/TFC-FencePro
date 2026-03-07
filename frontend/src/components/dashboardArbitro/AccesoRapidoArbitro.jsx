import { FileText, ChevronRight } from "lucide-react";

function AccesoRapidoArbitro(){

return(

<div className="arbitro-card arbitro-quick">

<h3>Acceso rápido</h3>

<div className="arbitro-quick-item">

<div className="arbitro-quick-left">
<FileText size={16}/>
<div>
<p>Mi Calendario</p>
<span>Activo</span>
</div>
</div>

<ChevronRight size={16}/>

</div>

<div className="arbitro-quick-item">

<div className="arbitro-quick-left">
<FileText size={16}/>
<div>
<p>Reglamento</p>
<span>Activo</span>
</div>
</div>

<ChevronRight size={16}/>

</div>

<div className="arbitro-quick-item">

<div className="arbitro-quick-left">
<FileText size={16}/>
<div>
<p>Pagos</p>
<span>Activo</span>
</div>
</div>

<ChevronRight size={16}/>

</div>

<div className="arbitro-quick-item">

<div className="arbitro-quick-left">
<FileText size={16}/>
<div>
<p>Contrato federativo</p>
<span>Activo</span>
</div>
</div>

<ChevronRight size={16}/>

</div>

<div className="arbitro-link">
+ Ver todos los planes
</div>

</div>

)

}

export default AccesoRapidoArbitro