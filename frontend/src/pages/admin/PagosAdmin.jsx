import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/pagosAdmin.css";
import { MoreHorizontal } from "lucide-react";
import { useState } from "react";

function PagosAdmin() {

const [openMenu,setOpenMenu] = useState(null);

const toggleMenu = (index) =>{
  setOpenMenu(openMenu === index ? null : index);
}

return (
<DashboardLayout>

<div className="pagos-admin">

<h2 className="pagos-title">Pagos</h2>

{/* STATS */}

<div className="pagos-stats">

<div className="pago-stat recibido">
<p>Recibidos</p>
<h3>2640</h3>
</div>

<div className="pago-stat pendiente">
<p>Pendientes</p>
<h3>2640</h3>
</div>

<div className="pago-stat fallido">
<p>Fallidos</p>
<h3>2640</h3>
</div>

<div className="pago-stat total">
<p>Total</p>
<h3>2640</h3>
</div>

</div>

{/* GRID */}

<div className="pagos-grid">

{/* TABLA */}

<div className="pagos-table">

<h4>Transacciones</h4>

<table>

<thead>
<tr>
<th>Nº</th>
<th>Usuario</th>
<th>Categoría</th>
<th>Club</th>
<th>Fecha</th>
<th>Importe</th>
<th>Estado</th>
<th>Acción</th>
</tr>
</thead>

<tbody>

{[...Array(8)].map((_,i)=>(
<tr key={i}>

<td>34</td>
<td>Carlos Martín</td>
<td>Cuota anual</td>
<td>Club Madrid</td>
<td>25.01.26</td>
<td>100,00€</td>

<td>
<span className="estado recibido">Recibido</span>
</td>

<td className="acciones">

<button
className="menu-btn"
onClick={()=>toggleMenu(i)}
>
<MoreHorizontal size={18}/>
</button>

{openMenu === i && (
<div className="acciones-menu">

<div className="menu-item">✔ Ver pago</div>
<div className="menu-item">➜ Generar factura</div>
<div className="menu-item">📄 Enviar recibo</div>
<div className="menu-item">⬇ Descargar recibo</div>

</div>
)}

</td>

</tr>
))}

</tbody>

</table>

<div className="table-link">
+ Ver total transacciones
</div>

</div>

{/* PANEL DERECHO */}

<div className="pagos-side">

<div className="side-card">

<h4>Facturación</h4>

<div className="report-item">
<span>Emitidas</span>
<span>2000</span>
</div>

<div className="report-item">
<span>Enviadas</span>
<span>2000</span>
</div>

<div className="side-link">
+ Generar nueva factura
</div>

</div>

<div className="side-card">

<h4>Conciliación</h4>

<div className="report-item">
<span>Validaciones manuales</span>
<span>2000</span>
</div>

<div className="report-item">
<span>Estados bancarios</span>
<span>2000</span>
</div>

<div className="side-link">
+ Confirmar transacciones
</div>

</div>

<div className="side-card">

<h4>Reportes financieros</h4>

<div className="report-item">
<span>Ingresos por periodo</span>
<span>Descargar</span>
</div>

<div className="report-item">
<span>Ingresos por club</span>
<span>Descargar</span>
</div>

<div className="report-item">
<span>Ingresos por licencia</span>
<span>Descargar</span>
</div>

<div className="side-link">
+ Descargar informe
</div>

</div>

</div>

</div>

</div>

</DashboardLayout>
);
}

export default PagosAdmin;