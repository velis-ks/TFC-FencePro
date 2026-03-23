function NewSeason(){

return(

<div className="config-card">

<h4>Nueva temporada</h4>

<div className="config-form">

<label>Nombre temporada</label>
<input/>

<label>Fecha inicio</label>
<input type="date"/>

<label>Fecha fin</label>
<input type="date"/>

<label>Estado</label>
<select>
<option>Planificada</option>
<option>Activa</option>
</select>

</div>

<div className="config-link">→ Crear temporada</div>

</div>

)

}

export default NewSeason;