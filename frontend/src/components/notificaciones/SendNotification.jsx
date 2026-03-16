function SendNotification(){

return(

<div className="notifications-card">

<h4>Enviar notificación</h4>

<div className="notifications-filters">

<span className="notifications-filter">Destinatario ▾</span>
<span className="notifications-filter">Usuario ▾</span>
<span className="notifications-filter">Club ▾</span>
<span className="notifications-filter">Categoría ▾</span>
<span className="notifications-filter">Competición ▾</span>

<button className="notifications-send">ENVIAR</button>

</div>

<label>Título:</label>
<input className="notifications-input"/>

<label>Mensaje:</label>
<textarea className="notifications-textarea"></textarea>

<div className="notifications-upload">

<span>Adjuntar archivo</span>

<div className="notifications-checks">
<label><input type="checkbox"/> App</label>
<label><input type="checkbox"/> Email</label>
</div>

</div>

<div className="notifications-actions">

<span>Guardar borrador</span>
<span>Guardar plantilla</span>
<span>Crear automatización</span>

</div>

</div>

)

}

export default SendNotification;