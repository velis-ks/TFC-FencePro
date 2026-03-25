import { FileText, ChevronRight } from "lucide-react";

function InformesQuickAccess(){

return(

<div className="card">

<h4>Acceso rápido</h4>

<div className="quick-row">

<div className="quick-left">
<FileText size={16}/>
<div>
<p>Licencias 2024</p>
<span>Activo · Descargar</span>
</div>
</div>

<ChevronRight size={16}/>

</div>


<div className="quick-row">

<div className="quick-left">
<FileText size={16}/>
<div>
<p>Ranking clubes</p>
<span>Activo · Descargar</span>
</div>
</div>

<ChevronRight size={16}/>

</div>


<div className="quick-row">

<div className="quick-left">
<FileText size={16}/>
<div>
<p>Finanzas Q1</p>
<span>Activo · Descargar</span>
</div>
</div>

<ChevronRight size={16}/>

</div>


<div className="quick-row">

<div className="quick-left">
<FileText size={16}/>
<div>
<p>Participaciones</p>
<span>Activo · Descargar</span>
</div>
</div>

<ChevronRight size={16}/>

</div>


<div className="card-link">
+ Descargar todo
</div>

</div>

)

}

export default InformesQuickAccess;