import { useState } from "react";
import ReactInputMask from "react-input-mask";

function AddContacts(props) {
  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");

  return (
    <div
      className="space-y-4 p-6 bg-gray-700 rounded-md shadow flex flex-col"
      onKeyDown={(event) => {
        if (event.key === "Enter") {
          document.getElementById("addContactButton").click();
        }
      }}
      tabIndex="0"
    >
      <div className="flex items-center space-x-5">
        <label className="p-2 text-white text-xl font-semibold w-24">
          Nome:
        </label>
        <input
          type="text"
          placeholder="Carlos Henrique"
          className="border border-gray-300 outline-gray-200 px-4 rounded-md w-full py-1"
          value={name}
          onChange={(event) => setName(event.target.value)}
        />
      </div>
      <div className="flex items-center space-x-1">
        <label className="p-2 text-white text-xl font-semibold w-24">
          Telefone:
        </label>
        <ReactInputMask
          mask="(99) 99999-9999"
          placeholder="(00) 00000-0000"
          className="border border-gray-300 outline-gray-200 px-4 rounded-md w-full py-1"
          value={phone}
          onChange={(event) => setPhone(event.target.value)}
        />
      </div>
      <button
        id="addContactButton"
        onClick={async () => {
          if (!name.trim() || !phone.trim() || phone.includes("_")) {
            alert("Preencha todos os campos corretamente!");
            return;
          }
          const newContact = { nome: name, telefone: phone };

          try {
            const response = await fetch("http://localhost:8080/contatos", {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify(newContact),
            });

            if (!response.ok) {
              throw new Error("Erro ao adicionar contato");
            }

            const savedContact = await response.json();
            props.onAddContactSubmit(savedContact);

            setName("");
            setPhone("");
          } catch (error) {
            console.error("Erro ao salvar contato: ", error);
            alert("Erro ao salvar contato!");
          }
        }}
        className="bg-gray-800 text-white px-4 py-2 rounded-md font-medium w-full"
      >
        Adicionar
      </button>
    </div>
  );
}
export default AddContacts;
