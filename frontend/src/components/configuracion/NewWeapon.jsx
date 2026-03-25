function NewWeapon(){

return(

<div className="config-card">

<h4>Nueva arma</h4>

<div className="config-form">

<label>Nombre arma</label>
<input/>

<label>Código</label>
<input/>

<label>Descripción</label>
<input/>

<label>Estado</label>
<select>
<option>Activa</option>
<option>Inactiva</option>
</select>

</div>

<div className="config-link">→ Crear arma</div>

</div>

)

}

export default NewWeapon;