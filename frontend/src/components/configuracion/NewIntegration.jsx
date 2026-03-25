function NewIntegration(){

return(

<div className="config-card">

<h4>Nueva integración</h4>

<div className="config-form">

<label>Nombre servicio</label>
<input defaultValue="Integración Stripe"/>

<label>Clave API pública</label>
<input/>

<label>Clave secreta</label>
<input/>

<label>Modo</label>
<select>
<option>Test</option>
<option>Producción</option>
</select>

</div>

<div className="config-link">→ Guardar configuración</div>

</div>

)

}

export default NewIntegration;