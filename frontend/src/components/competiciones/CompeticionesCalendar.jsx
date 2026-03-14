import { useState } from "react";

function CompeticionesCalendar(){

const [currentDate,setCurrentDate] = useState(new Date(2026,2));
const [selectedDay,setSelectedDay] = useState(null);

const [eventTitle,setEventTitle] = useState("");
const [eventColor,setEventColor] = useState("verde");

const [events,setEvents] = useState({});

const months=[
"Enero","Febrero","Marzo","Abril","Mayo","Junio",
"Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"
];

const days=["L","M","X","J","V","S","D"];

const year=currentDate.getFullYear();
const month=currentDate.getMonth();

const firstDay=new Date(year,month,1).getDay();
const daysInMonth=new Date(year,month+1,0).getDate();

function prevMonth(){
setCurrentDate(new Date(year,month-1));
}

function nextMonth(){
setCurrentDate(new Date(year,month+1));
}

function selectDay(day){

const key=`${year}-${month+1}-${day}`;

setSelectedDay(key);

if(events[key]){
setEventTitle(events[key].title);
setEventColor(events[key].color);
}else{
setEventTitle("");
setEventColor("verde");
}

}

function saveEvent(){

if(!selectedDay || eventTitle==="") return;

setEvents({
...events,
[selectedDay]:{
title:eventTitle,
color:eventColor
}
})

}

function deleteEvent(){

if(!selectedDay) return;

const newEvents={...events};

delete newEvents[selectedDay];

setEvents(newEvents);

setEventTitle("");
}

return(

<div className="card calendario">

<div className="calendar-header">

<button onClick={prevMonth}>‹</button>

<h4>{months[month]} {year}</h4>

<button onClick={nextMonth}>›</button>

</div>

<div className="calendar-grid">

{days.map(d=>(
<div key={d} className="calendar-day">
{d}
</div>
))}

{Array.from({length:firstDay===0?6:firstDay-1}).map((_,i)=>(
<div key={"empty"+i}></div>
))}

{Array.from({length:daysInMonth}).map((_,i)=>{

const day=i+1;
const key=`${year}-${month+1}-${day}`;
const event=events[key];

return(

<div
key={day}
className="calendar-cell"
onClick={()=>selectDay(day)}
>

{event && (

<div className={`evento ${event.color}`}>
{event.title}
</div>

)}

{day}

</div>

)

})}

</div>

{/* PANEL CREAR EVENTO */}

<div className="calendar-create">

<input
type="text"
placeholder="Nombre competición"
value={eventTitle}
onChange={(e)=>setEventTitle(e.target.value)}
/>

<select
value={eventColor}
onChange={(e)=>setEventColor(e.target.value)}
>

<option value="verde">Florete</option>
<option value="azul">Espada</option>
<option value="rojo">Sable</option>

</select>

<button onClick={saveEvent}>
Guardar
</button>

<button
className="delete-btn"
onClick={deleteEvent}
>
Eliminar
</button>

</div>

</div>

)

}

export default CompeticionesCalendar;