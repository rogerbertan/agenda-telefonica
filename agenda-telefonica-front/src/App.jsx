import Contacts from "./components/Contacts";
import AddContacts from "./components/AddContacts";
import { useState } from "react";
import { useEffect } from "react";

function App() {
  const [contacts, setContacts] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/contatos")
      .then((response) => response.json())
      .then((data) => {
        console.log("Dados recebidos: ", data);
        setContacts(data);
      })
      .catch((error) => console.error("Erro ao buscar contatos: ", error));
  }, []);

  const onDeleteContactClick = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/contatos/${id}`, {
        method: "DELETE",
      });

      if (!response.ok) {
        throw new Error("Erro ao deletar contato");
      }
      setContacts((prevContacts) =>
        prevContacts.filter((contact) => contact.id !== id)
      );
    } catch (error) {
      console.error("Erro ao excluir contato: ", error);
      alert("Erro ao excluir contato!");
    }
  };

  function onAddContactSubmit(newContact) {
    setContacts((prevContacts) => [...prevContacts, newContact]);
  }

  return (
    <div className="w-screen h-screen flex bg-gray-900 justify-center p-6">
      <div className="w-[500px] space-y-4">
        <h1 className="text-3xl font-bold text-center text-gray-200 p-4">
          Agenda Telefônica
        </h1>
        <AddContacts onAddContactSubmit={onAddContactSubmit} />
        <Contacts
          contacts={contacts}
          onDeleteContactClick={onDeleteContactClick}
        />
      </div>
    </div>
  );
}

export default App;
