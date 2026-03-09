import { Users, FileText, CreditCard, BarChart3, ChevronRight } from "lucide-react";

function AccesoRapidoClub() {
  return (
    <div className="club-card acceso-rapido">
      <h4>Acceso rápido</h4>

      <div className="quick-item">
        <div className="quick-left">
          <Users size={18} />
          <div>
            <span>Gestión de Deportistas</span>
            <small>Activo</small>
          </div>
        </div>
        <ChevronRight size={18} className="arrow"/>
      </div>

      <div className="quick-item">
        <div className="quick-left">
          <FileText size={18} />
          <div>
            <span>Renovar Licencias</span>
            <small>Activo</small>
          </div>
        </div>
        <ChevronRight size={18} className="arrow"/>
      </div>

      <div className="quick-item">
        <div className="quick-left">
          <CreditCard size={18} />
          <div>
            <span>Nuevo Pago</span>
            <small>Activo</small>
          </div>
        </div>
        <ChevronRight size={18} className="arrow"/>
      </div>

      <div className="quick-item">
        <div className="quick-left">
          <BarChart3 size={18} />
          <div>
            <span>Informes y Estadísticas</span>
            <small>Activo</small>
          </div>
        </div>
        <ChevronRight size={18} className="arrow"/>
      </div>

      <div className="quick-footer">
        + Ver todos los planes
      </div>
    </div>
  );
}

export default AccesoRapidoClub;