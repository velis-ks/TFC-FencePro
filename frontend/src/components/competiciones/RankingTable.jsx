function RankingTable(){

return(

<div className="card">

<div className="filtros">

<div className="filtro">Competición ▾</div>
<div className="filtro">Arma ▾</div>
<div className="filtro">Categoría ▾</div>

<button className="btn-filtrar">
+ Filtrar
</button>

</div>

<h4>Ranking</h4>

<table>

<thead>

<tr>

<th>Posición</th>
<th>Deportista</th>
<th>Club</th>
<th>Combates</th>
<th>Victorias</th>
<th>Puntos</th>

</tr>

</thead>

<tbody>

<tr>
<td>1</td>
<td>Carlos M.</td>
<td>Madrid</td>
<td>22</td>
<td>22</td>
<td>100</td>
</tr>

<tr>
<td>2</td>
<td>Carlos M.</td>
<td>Madrid</td>
<td>22</td>
<td>21</td>
<td>100</td>
</tr>

</tbody>

</table>

</div>

)

}

export default RankingTable;