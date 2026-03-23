function RulesConfig(){

return(

<div className="config-card">

<h4>Reglas globales</h4>

<div className="config-form">

<label>Edad mínima licencia</label>
<input defaultValue="6"/>

<label>Duración licencia (meses)</label>
<input defaultValue="12"/>

<label>Máximo competiciones temporada</label>
<input defaultValue="15"/>

</div>

<div className="config-link">
→ Guardar cambios | Restaurar valores
</div>

</div>

)

}

export default RulesConfig;