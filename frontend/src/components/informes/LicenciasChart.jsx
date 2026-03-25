function LicenciasChart(){

return(

<div className="card">

<h4>Licencias</h4>

<p className="chart-subtitle">
Licencias por temporada
</p>

<div className="line-chart">

<svg viewBox="0 0 200 80" className="chart-svg">

{/* grid */}
<line x1="0" y1="60" x2="200" y2="60" className="grid"/>
<line x1="40" y1="0" x2="40" y2="80" className="grid"/>
<line x1="80" y1="0" x2="80" y2="80" className="grid"/>
<line x1="120" y1="0" x2="120" y2="80" className="grid"/>
<line x1="160" y1="0" x2="160" y2="80" className="grid"/>

{/* línea */}
<polyline
points="0,55 40,50 80,45 120,43 160,25"
className="chart-line"
/>

{/* puntos */}
<circle cx="0" cy="55" r="2" className="chart-point"/>
<circle cx="40" cy="50" r="2" className="chart-point"/>
<circle cx="80" cy="45" r="2" className="chart-point"/>
<circle cx="120" cy="43" r="2" className="chart-point"/>
<circle cx="160" cy="25" r="2" className="chart-point"/>

</svg>

<div className="chart-labels">
<span>25-26</span>
<span>26-27</span>
<span>27-28</span>
<span>28-29</span>
<span>29-30</span>
</div>

</div>

<div className="licencia-stats">

<div className="licencia-row">
<span>Nuevas</span>
<b>2000</b>
</div>

<div className="licencia-row">
<span>Renovaciones</span>
<b>2000</b>
</div>

</div>

<div className="card-link">
+ Gestionar licencias
</div>

</div>

)

}

export default LicenciasChart;