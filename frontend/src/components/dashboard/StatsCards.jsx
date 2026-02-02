import InscriptionsStatCard from './InscriptionsStatCard';


function StatsCards() {
  return (
    <>

      <div className="stat-card green">
        <h4>Activas</h4>
        <p>2640</p>
      </div>

      <div className="stat-card red">
        <h4>Caducadas</h4>
        <p>2640</p>
      </div>

      <div className="stat-card blue">
        <h4>Pte. renovación</h4>
        <p>2640</p>
      </div>

      <div className="stat-card orange">
        <h4>Alerta caducidad</h4>
        <p>2640</p>
      </div>


      <InscriptionsStatCard />

    </>
  );
}

export default StatsCards;