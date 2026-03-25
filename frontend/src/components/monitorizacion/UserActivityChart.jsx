import { useState } from "react";

function UserActivityChart(){

const [period,setPeriod] = useState("Mensual")
const [open,setOpen] = useState(false)

const data = {
Mensual: "10,60 40,55 70,50 100,52 130,45 160,30",
Semanal: "10,70 40,60 70,65 100,50 130,40 160,35",
Diaria: "10,65 40,60 70,62 100,58 130,55 160,52",
Anual: "10,70 40,65 70,60 100,55 130,50 160,45"
}

return(

<div className="monitor-box">

<h4>Actividad usuarios</h4>

<div className="monitor-chart-header">

<div 
className="monitor-dropdown"
onClick={()=>setOpen(!open)}
>

<span>{period}</span>
<span className="arrow">▾</span>

{open && (

<div className="monitor-dropdown-menu">

<div onClick={()=>{setPeriod("Semanal");setOpen(false)}}>Semanal</div>
<div onClick={()=>{setPeriod("Diaria");setOpen(false)}}>Diaria</div>
<div onClick={()=>{setPeriod("Anual");setOpen(false)}}>Anual</div>
<div onClick={()=>{setPeriod("Mensual");setOpen(false)}}>Mensual</div>

</div>

)}

</div>

</div>


<div className="monitor-line-chart">

<svg viewBox="0 0 200 80" preserveAspectRatio="none">

<polyline
fill="none"
stroke="#2e7d32"
strokeWidth="2"
points={data[period]}
/>

</svg>

</div>


<div className="monitor-mini-stats">

<div className="monitor-row">
<span>Nuevas</span>
<b>2000</b>
</div>

<div className="monitor-row">
<span>Renovaciones</span>
<b>2000</b>
</div>

</div>

<div className="monitor-link">+ Gestionar licencias</div>

</div>

)

}

export default UserActivityChart;