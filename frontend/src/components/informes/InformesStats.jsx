import { Users, Swords, UserRound, Euro } from "lucide-react";

function InformesStats(){

return(

<div className=" informes informes-stats">

<div className=" informes stat-card stat-green">

<div className="stat-header">
<Users size={18}/>
<span>Total licencias</span>
</div>

<h2>320</h2>

<p>Activas <b>200</b></p>

</div>

<div className="stat-card stat-blue">

<div className="stat-header">
<Swords size={18}/>
<span>Competiciones activas</span>
</div>

<h2>230</h2>

<p>Próximas <b>80</b></p>

</div>

<div className=" informes stat-card stat-yellow">

<div className="stat-header">
<UserRound size={18}/>
<span>Total deportistas</span>
</div>

<h2>17</h2>

<p>Activos</p>

</div>

<div className="stat-card stat-orange">

<div className="stat-header">
<Euro size={18}/>
<span>Ingresos pendientes</span>
</div>

<h2>12</h2>

<p>850€</p>

</div>

</div>

)

}

export default InformesStats;