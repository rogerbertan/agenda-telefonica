import { Trash2 } from "lucide-react";

function Contacts(props) {
  return (
    <div className="overflow-x-auto rounded-lg">
      <table className="min-w-full border border-gray-700 rounded-lg">
        <thead>
          <tr className="bg-gray-800 text-white">
            <th className="px-6 py-3 text-left border-r border-black">Nome</th>
            <th className="px-6 py-3 text-left border-r border-black">
              Telefone
            </th>
            <th className="px-6 py-3 text-center">Ações</th>
          </tr>
        </thead>

        <tbody>
          {props.contacts.map((contact) => (
            <tr key={contact.id} className="border-b border-black bg-gray-700">
              <td className="px-6 py-3 border-r border-black">
                {contact.nome}
              </td>
              <td className="px-6 py-3 border-r border-black">
                {contact.telefone}
              </td>
              <td className="px-6 py-3 text-center">
                <button
                  onClick={() => props.onDeleteContactClick(contact.id)}
                  className="bg-gray-800 text-white px-3 py-1 rounded-md transition"
                >
                  <Trash2 />
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
export default Contacts;
