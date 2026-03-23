function SystemConfig(){

return(

<div className="config-card">

<h4>Configuración del sistema</h4>

<div className="config-form">

<label>Idioma sistema</label>
<select>
<option>Español</option>
<option>Inglés</option>
</select>

<label>Zona horaria</label>
<select>
<option>Europa/Madrid</option>
</select>

<label>Formato fecha</label>
<select>
<option>DD/MM/YYYY</option>
</select>

</div>

<div className="config-link">
→ Guardar cambios | Restaurar valores
</div>

</div>

)

}

export default SystemConfig;