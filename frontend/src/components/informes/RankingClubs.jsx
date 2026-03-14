function RankingClubs(){

const data = [
{pos:1, club:"Madrid", puntos:100},
{pos:2, club:"Madrid", puntos:100},
{pos:3, club:"Madrid", puntos:100},
{pos:4, club:"Madrid", puntos:90},
{pos:5, club:"Madrid", puntos:85},
{pos:6, club:"Madrid", puntos:80},
{pos:7, club:"Madrid", puntos:75},
];

return(

<div className="card">

<h4>Ranking clubes</h4>

<table className="ranking-table">

<thead>
<tr>
<th>Posición</th>
<th>Club</th>
<th>Puntos</th>
</tr>
</thead>

<tbody>

{data.map((club,i)=>(
<tr key={i}>

<td>
{i === 0 ? "🥇" : i === 1 ? "🥈" : i === 2 ? "🥉" : i + 1}
</td>

<td>{club.club}</td>

<td>{club.puntos}</td>

</tr>
))}

</tbody>

</table>

<div className="card-link">
+ Descargar ranking completo
</div>

</div>

)

}

export default RankingClubs;