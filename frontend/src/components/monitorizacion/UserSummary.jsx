function UserSummary(){

return(

<div className="monitor-box">

<h4>Resumen usuarios</h4>

<div className="monitor-user-grid">

<div className="monitor-user-stats">

<div className="monitor-row">
<span>Usuarios activos mes</span>
<b className="monitor-green">2000</b>
</div>

<div className="monitor-row">
<span>Nuevos usuarios</span>
<b className="monitor-red">2000</b>
</div>

<div className="monitor-row">
<span>Sesiones hoy</span>
<b>2000</b>
</div>

<div className="monitor-row">
<span>Tiempo medio app</span>
<b>2,3s</b>
</div>

</div>


<div className="monitor-summary-chart">

<div className="monitor-summary-legend">

<div className="legend-row">
<span className="legend-color deportistas"></span>
Deportistas
</div>

<div className="legend-row">
<span className="legend-color entrenadores"></span>
Entrenadores
</div>

<div className="legend-row">
<span className="legend-color arbitros"></span>
Árbitros
</div>

<div className="legend-row">
<span className="legend-color federativos"></span>
Federativos
</div>

</div>


<div className="monitor-donut">

<div className="monitor-donut-circle"></div>

<span className="donut-value donut-green">65%</span>
<span className="donut-value donut-red">5%</span>
<span className="donut-value donut-blue">5%</span>
<span className="donut-value donut-orange">5%</span>

</div>

</div>

</div>

</div>

)

}

export default UserSummary;