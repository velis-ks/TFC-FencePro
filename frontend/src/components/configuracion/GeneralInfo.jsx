function GeneralInfo(){

return(

<div className="config-card">

<h4>Información general</h4>

<div className="config-form">

<label>Nombre Federación</label>
<input defaultValue="Real Federación Española de Esgrima"/>

<label>País</label>
<input defaultValue="España"/>

<label>Dirección</label>
<input defaultValue="C/ Deporte 34"/>

<label>Email</label>
<input defaultValue="admin@email.com"/>

<label>Teléfono</label>
<input defaultValue="654321654"/>

</div>

<div className="config-link">→ Guardar cambios | Restaurar valores</div>

</div>

)

}

export default GeneralInfo;