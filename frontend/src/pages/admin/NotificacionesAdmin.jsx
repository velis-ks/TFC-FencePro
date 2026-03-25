import DashboardLayout from "../../layouts/DashboardLayout";
import "../../styles/notificacionesAdmin.css";

import SendNotification from "../../components/notificaciones/SendNotification";
import NotificationTemplates from "../../components/notificaciones/NotificationTemplates";
import NotificationHistory from "../../components/notificaciones/NotificationHistory";
import NotificationAutomation from "../../components/notificaciones/NotificationAutomation";

function NotificacionesAdmin(){

return(

<DashboardLayout>

<div className="notifications-admin">

<h2 className="notifications-title">Notificaciones</h2>

<div className="notifications-grid-top">

<SendNotification/>
<NotificationTemplates/>

</div>

<div className="notifications-grid-bottom">

<NotificationHistory/>
<NotificationAutomation/>

</div>

</div>

</DashboardLayout>

)

}

export default NotificacionesAdmin;