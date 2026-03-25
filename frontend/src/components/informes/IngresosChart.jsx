function IngresosChart(){

return(

<div className="card">

<h4>Ingresos</h4>

<div className="ingresos-layout">

{/* BARRAS */}

<div className="bars-section">

<div className="bars">

<div style={{height:"55%"}}></div>
<div style={{height:"40%"}}></div>
<div style={{height:"20%"}}></div>
<div style={{height:"60%"}}></div>
<div style={{height:"45%"}}></div>
<div style={{height:"55%"}}></div>
<div style={{height:"40%"}}></div>
<div style={{height:"30%"}}></div>
<div style={{height:"50%"}}></div>
<div style={{height:"60%"}}></div>
<div style={{height:"70%"}}></div>
<div style={{height:"65%"}}></div>

</div>

<div className="bar-labels">
<span>E</span>
<span>F</span>
<span>M</span>
<span>A</span>
<span>M</span>
<span>J</span>
<span>J</span>
<span>A</span>
<span>S</span>
<span>O</span>
<span>N</span>
<span>D</span>
</div>

</div>


{/* TEXTO CENTRAL */}

<div className="ingresos-info">

<p>Ingresos por mes</p>
<h2>15.800€</h2>

<div className="legend">

<div className="legend-row">
<span className="legend-color licencias"></span>
Licencias federativas
</div>

<div className="legend-row">
<span className="legend-color inscrip"></span>
Inscrip competiciones
</div>

<div className="legend-row">
<span className="legend-color cuotas"></span>
Cuotas de clubes
</div>

<div className="legend-row">
<span className="legend-color formacion"></span>
Formación técnica
</div>

</div>

</div>


{/* DONUT */}

<div className="donut">

<div className="donut-circle"></div>

<div className="donut-value donut-v1">55%</div>
<div className="donut-value donut-v2">20%</div>
<div className="donut-value donut-v3">15%</div>
<div className="donut-value donut-v4">10%</div>


</div>

</div>

<div className="card-link">
+ Descargar informe ingresos y gastos
</div>

</div>

)

}

export default IngresosChart