import type { Route } from "./+types/carte";

export function meta({}: Route.MetaArgs) {
    return [
        { title: "Lateb - Carte des bières" },
        { name: "description", content: "L'Association des Teks Experts en Bière" },
    ];
}

export default function Carte() {
    return (
        <div className="flex flex-col items-center justify-center min-h-screen">
            <h1 className="text-4xl font-bold mb-4">Carte des bières</h1>
            <p className="text-lg text-gray-700">Découvrez notre sélection de bières !</p>
        </div>
    );
}