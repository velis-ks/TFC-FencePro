function HistorialArbitro() {

    return (

        <div className="arbitro-card">

            <h3>Historial</h3>

            <table>

                <thead>
                    <tr>
                        <th>Competición</th>
                        <th>Combates</th>
                        <th>Resultado</th>
                    </tr>
                </thead>

                <tbody>

                    <tr>
                        <td>Prueba Cto España silla ruedas</td>
                        <td>15</td>
                        <td>
                            <span className="arbitro-dot arbitro-dot-green"></span>
                            Finalizado
                        </td>

                        
                    </tr>
                    <tr>
                        <td>Prueba Cto España silla ruedas</td>
                        <td>15</td>
                        <td>
                            <span className="arbitro-dot arbitro-dot-green"></span>
                            Finalizado
                        </td>

                        
                    </tr>
                    <tr>
                        <td>Prueba Cto España silla ruedas</td>
                        <td>15</td>
                        <td>
                            <span className="arbitro-dot arbitro-dot-orange"></span>
                            Activo
                        </td>

                        
                    </tr>

                </tbody>

            </table>

            <div className="arbitro-link">
                + Ver historial completo
            </div>

        </div>

    )

}

export default HistorialArbitro