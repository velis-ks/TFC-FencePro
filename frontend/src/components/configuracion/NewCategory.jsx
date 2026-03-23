function NewCategory(){

return(

<div className="config-card">

<h4>Nueva categoría</h4>

<div className="config-form">

<label>Nombre</label>
<input/>

<label>Edad mín</label>
<input/>

<label>Edad máx</label>
<input/>

<label>Tipo</label>
<select>
<option>Formación</option>
<option>Competición</option>
</select>

</div>

<div className="config-link">→ Crear categoría</div>

</div>

)

}

export default NewCategory;